package org.example.healthcare.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

   public List<User> selectAll(){
      return userRepository.findAll();
   }

    public User createTask(User user) {
        return  userRepository.save(user);
    }

    public User updateUser(Long id , User updatedUser) {
        var user =  userRepository.findById(id).orElseThrow(()-> new RuntimeException("task not found"));
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setEmail(updatedUser.getEmail());
        user.setPhone(updatedUser.getPhone());
        user.setDate_of_birth(updatedUser.getDate_of_birth());
        return userRepository.save(user);
    }

}
