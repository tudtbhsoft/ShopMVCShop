package com.demo.service;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.demo.entity.Product;
import com.demo.entity.User;
import com.demo.repository.UserRepository;
import net.bytebuddy.asm.Advice.Return;

@Service
public class UserService {
	@Autowired
	UserRepository repo;

	@Transactional(readOnly = true)
	public List<User> listAll() {
		return (List<User>) repo.findAll();
	}

	@Transactional
	public void save(User user) {
		repo.save(user);
	}

}
