package com.example.blogmanagement.service.implementation;

import com.example.blogmanagement.dto.LoginRequestDto;
import com.example.blogmanagement.dto.PostsDto;
import com.example.blogmanagement.entity.posts;
import com.example.blogmanagement.entity.users;
import com.example.blogmanagement.repository.postsrepository;
import com.example.blogmanagement.service.postinterface;
import com.example.blogmanagement.mapper.postsmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.blogmanagement.repository.userrepository;

import java.util.List;
import java.util.Optional;

@Service
public class postsserviceimplementation implements postinterface {

    private postsrepository postsrepository;
    @Autowired
    public postsserviceimplementation(postsrepository postsrepository) {
        this.postsrepository = postsrepository;
    }

    @Autowired
    private userrepository userrepository;

    @Override
    public PostsDto createPost(PostsDto postsDto,Integer userId) {
        posts posts=postsmapper.maptoposts(postsDto);
        Optional<users> optinaluser= userrepository.findById(userId);
        users user=optinaluser.get();
        posts.setUsers(user);
        PostsDto saved_post=postsmapper.maptopostsDto(postsrepository.save(posts));
        return saved_post;
    }

    @Override
    public PostsDto updatelikes(Integer postid) {
        Optional<posts> optionalpost=postsrepository.findById(postid);
        posts post=optionalpost.get();
        post.incrementlikes();
        PostsDto saved_post=postsmapper.maptopostsDto(postsrepository.save(post));
        return saved_post;

    }

    @Override
    public List<posts> getallpostsbyusername(LoginRequestDto loginRequestDto) {
        Optional<users> optinaluser=userrepository.findByUsernameAndPassword(loginRequestDto.getUsername(), loginRequestDto.getPassword());
        users users=optinaluser.get();
        return postsrepository.findByusers(users);
    }
}
