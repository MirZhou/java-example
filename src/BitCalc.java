/**
 * 位运算
 * <p>Create time: 2020-05-25 16:59</p>
 *
 * @author Eros
 **/
public class BitCalc {
    public static void main(String[] args) {
        int userRoleCode = 1;

        System.out.println("======================");
        outRole(userRoleCode);

        userRoleCode += UserRole.JIGOU.getRoleCode();

        System.out.println("======================");
        outRole(userRoleCode);

        userRoleCode += UserRole.GOV.getRoleCode();

        System.out.println("======================");
        outRole(userRoleCode);

        userRoleCode += UserRole.PLATFORM.getRoleCode();

        System.out.println("======================");
        outRole(userRoleCode);

    }

    private static void outRole(int roleCode) {
        System.out.println((roleCode & UserRole.NORMAL_USER.getRoleCode()) == UserRole.NORMAL_USER.getRoleCode());
        System.out.println((roleCode & UserRole.JIGOU.getRoleCode()) == UserRole.JIGOU.getRoleCode());
        System.out.println((roleCode & UserRole.GOV.getRoleCode()) == UserRole.GOV.getRoleCode());
        System.out.println((roleCode & UserRole.PLATFORM.getRoleCode()) == UserRole.PLATFORM.getRoleCode());
    }
}
