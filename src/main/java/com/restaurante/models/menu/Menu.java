package com.restaurante.models.menu;

public class Menu {

	public String menuId;
	
	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String menuName;

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public Menu(String menuId, String menuName) {
		this.menuId = menuId;
		this.menuName = menuName;
	}
}
