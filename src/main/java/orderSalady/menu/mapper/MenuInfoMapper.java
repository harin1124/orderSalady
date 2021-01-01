package orderSalady.menu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import orderSalady.menu.domain.MenuInfoDto;
import orderSalady.menu.domain.MenuInfoVo;

@Mapper
public interface MenuInfoMapper {
	List<MenuInfoVo> selectMenuInfoAllList();
	
	MenuInfoVo selectMenuInfo(MenuInfoDto param);
}
