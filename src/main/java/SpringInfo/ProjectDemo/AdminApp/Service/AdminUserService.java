package SpringInfo.ProjectDemo.AdminApp.Service;


import SpringInfo.ProjectDemo.AdminApp.Dto.AdminRegistrationDto;
import SpringInfo.ProjectDemo.AdminApp.Dto.AdminLoginDto;

public interface AdminUserService {
    void registerAdmin(AdminRegistrationDto registrationDTO);
    String authenticateAdmin(AdminLoginDto loginDTO) throws Exception;
}