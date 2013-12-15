package incantations.block;

import incantations.common.Incantations;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import incantations.tileentity.TileEntityWritingDesk;

public class BlockWritingDesk extends Block implements ITileEntityProvider {
	public BlockWritingDesk(int id) {
		super(id, Material.wood);
		setUnlocalizedName("writingDesk");
		setHardness(10f);
		setCreativeTab(Incantations.tabIncantations);
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityWritingDesk();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int meta, float par7, float par8, float par9) {
		if (!entityPlayer.isSneaking()) entityPlayer.openGui(Incantations.instance, 0, world, x, y, z);
		return true;
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, int blockID, int meta) {
		TileEntityWritingDesk tileEntityWritingDesk = (TileEntityWritingDesk) world.getBlockTileEntity(x, y, z);
		for (int i = -1; i >= -5; i--) {
			ItemStack itemStack = tileEntityWritingDesk.getStackInSlot(i);
			if (itemStack != null) {
				EntityItem entityItem = new EntityItem(world, x, y, z, itemStack);
				entityItem.motionX = world.rand.nextGaussian() * 0.05f;
				entityItem.motionY = world.rand.nextGaussian() * 0.05f;
				entityItem.motionZ = world.rand.nextGaussian() * 0.05f;
			}
		}
		super.breakBlock(world, x, y, z, blockID, meta);
	}
}
