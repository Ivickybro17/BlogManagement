package com.example.blogmanagement.service.implementation;

import com.example.blogmanagement.entity.Follows;
import com.example.blogmanagement.entity.Users;
import com.example.blogmanagement.repository.FollowsRepository;
import com.example.blogmanagement.repository.UserRepository;
import com.example.blogmanagement.service.FollowsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FollowsServiceImplementation implements FollowsInterface {

    private FollowsRepository followsrepository;
    @Autowired
    public FollowsServiceImplementation(FollowsRepository followsrepository) {
        this.followsrepository = followsrepository;
    }

    @Autowired
    private UserRepository userrepository;

    @Override
    public Follows createFollow(Follows follows, int user_id) {
        Optional<Users> optinaluser= userrepository.findById(user_id);
        Users user=optinaluser.get();
        follows.setUsers(user);
        Follows saved_follows=followsrepository.save(follows);
        return saved_follows;
    }

}
