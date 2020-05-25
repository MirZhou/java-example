/**
 * <p>Create time: 2020-05-25 17:31</p>
 *
 * @author Eros
 **/
public enum UserRole {
    /**
     * 普通用户
     */
    NORMAL_USER(1, "普通用户"),
    /**
     * 机构用户
     */
    JIGOU(2, "机构用户"),
    /**
     * 政府
     */
    GOV(4, "政府"),
    /**
     * 平台
     */
    PLATFORM(8, "平台");

    /**
     * 角色码
     */
    private final Integer roleCode;
    /**
     * 角色名称
     */
    private final String roleName;

    UserRole(Integer roleCode, String roleName) {
        this.roleCode = roleCode;
        this.roleName = roleName;
    }

    public Integer getRoleCode() {
        return roleCode;
    }

    public String getRoleName() {
        return roleName;
    }
}
