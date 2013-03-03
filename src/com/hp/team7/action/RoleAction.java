package com.hp.team7.action;

import java.util.List;

import com.hp.team7.service.RoleService;
import com.hp.team7.vo.Role;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户权限管理Action类
 * @author k95
 */
public class RoleAction extends ActionSupport {

	
	private static final long serialVersionUID = -5782663810107302518L;
	
	private int id;					//角色ID
	private String name;			//角色名
	private String description;		//角色描述
	private List<Role> roleList;
	private RoleService roleService;

	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the roleList
	 */
	public List<Role> getRoleList() {
		return roleList;
	}

	/**
	 * @param roleList the roleList to set
	 */
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	/**
	 * @return the roleService
	 */
	public RoleService getRoleService() {
		return roleService;
	}

	/**
	 * @param roleService the roleService to set
	 */
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	
	/**
	 * 添加角色
	 * @return
	 */
	public String addRole(){
		if("".equals(name.trim()) || name==null){
			clear();
			return "error";
		}
		else{
			if(roleService.addRole(name, description)){
				clear();
				return "success";
			}else{
				clear();
				return "error";
			}
		}
	}
	
	/**
	 * 查询角色信息
	 */
	public String queryRole() {
		if(name==null){
			name="";
		}
		roleList = roleService.queryRole(name);
		clear();
		return "success";
	}
	
	
	/**
	 * 删除角色
	 * @return
	 */
	public String deleteRole(){
		if(id==1 || id==2 || id==3){
			clear();
			return "error";
		}
	    else if(roleService.deleteRole(id)){
			clear();
			return "success";
		}else{
			clear();
			return "error";
		}
	}
	
	
	/**
	 * 修改角色描述信息
	 * @return
	 */
	public String modifyRole(){
		if(id==1 || id==2 || id==3){
			clear();
			return "error";
		}
		else if(roleService.modifyRole(id, description, name)){
			clear();
			return "success";
		}else{
			clear();
			return "error";
		}
	}
	
	/**
	 * 清理残留信息
	 */
	public void clear(){
		id=0;
		name="";
		description="";
	}
	
}
