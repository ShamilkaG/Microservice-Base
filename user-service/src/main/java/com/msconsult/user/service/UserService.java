package com.msconsult.user.service;

import com.msconsult.user.entity.User;
import com.msconsult.user.repository.UserRepository;
import com.msconsult.user.vo.Department;
import com.msconsult.user.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Insside saveUser in User Service");
        return userRepository.save(user);
    }

    public User findUserById(Long userId) {
        log.info("Insside findUserById in User Service");
        return userRepository.findByUserId(userId);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Insside getUserWithDepartment in User Service");
       ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
       User user = userRepository.findByUserId(userId);

        Department department =
//                restTemplate.getForObject("http://localhost:9001/departments/ " + user.getUserId(),Department.class);
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/ " + user.getUserId(),Department.class);

        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(department);

        return  responseTemplateVO;
    }
}
