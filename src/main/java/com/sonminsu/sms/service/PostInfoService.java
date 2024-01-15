package com.sonminsu.sms.service;

import com.sonminsu.sms.model.Post;
import com.sonminsu.sms.model.PostInfo;
import com.sonminsu.sms.repository.PostInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor

@Service
public class PostInfoService {

    private final PostInfoRepository postInfoRepository;

    public void createPostInfo(Post post, String brandName, String prodectName, String urlLink){
        PostInfo postInfo = new PostInfo();
        postInfo.setBrandName(brandName);
        postInfo.setProdectName(prodectName);
        postInfo.setUrlLink(urlLink);
        postInfo.setPost(post);
        this.postInfoRepository.save(postInfo);
    }
}
