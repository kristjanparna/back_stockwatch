package ee.valiit.stockwatch.domain.user.role;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleService {

    @Resource
    private RoleRepository roleRepository;

    public Role getRoleByType(String type) {
        return roleRepository.findByType(type);
    }
}
