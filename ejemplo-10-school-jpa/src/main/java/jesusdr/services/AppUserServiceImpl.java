package jesusdr.services;

import jesusdr.entities.AppUser;
import jesusdr.repositories.AppUserRepository;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;

    public AppUserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public AppUser save(AppUser user) {
        return appUserRepository.save(user);
    }
}
