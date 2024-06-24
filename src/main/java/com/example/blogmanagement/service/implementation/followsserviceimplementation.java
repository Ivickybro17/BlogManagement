package com.example.blogmanagement.service.implementation;

import com.example.blogmanagement.dto.FollowsDto;
import com.example.blogmanagement.entity.follows;
import com.example.blogmanagement.entity.users;
import com.example.blogmanagement.repository.followsrepository;
import com.example.blogmanagement.repository.userrepository;
import com.example.blogmanagement.service.followsinterface;
import com.example.blogmanagement.mapper.followsmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class followsserviceimplementation implements followsinterface {

    private followsrepository followsrepository;
    @Autowired
    public followsserviceimplementation(followsrepository followsrepository) {
        this.followsrepository = followsrepository;
    }

    @Autowired
    private userrepository userrepository;

    @Override
    public FollowsDto createFollow(FollowsDto followsDto, int user_id) {
        follows follows = followsmapper.maptofollows(followsDto);
        Optional<users> optinaluser= userrepository.findById(user_id);
        users user=optinaluser.get();
        follows.setUsers(user);
        FollowsDto saved_follows=followsmapper.maptofollowsDto(followsrepository.save(follows));
        return saved_follows;
    }

}
