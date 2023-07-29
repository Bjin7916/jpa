package com.jpa.task.repository.post;

import com.jpa.task.domain.PostDTO;
import com.jpa.task.domain.PostSearch;
import com.jpa.task.entity.Post;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import java.awt.*;
import java.util.List;
import java.util.Optional;

import static com.jpa.task.entity.QPost.post;
import static com.jpa.task.entity.QReply.reply;

@RequiredArgsConstructor
public class PostQueryDSLImpl implements PostQueryDSL {
    private final JPAQueryFactory query;

//    @Override
//    public List<PostDTO> findAllWithReplyCount() {
////        select절에서 서브쿼리(JPAExpressions)를 사용한다면, Projections를 사용해야 한다.
////        Projections.fields() : 필드명 매핑
////        Projections.constructor() : 생성자 사용
//        return  query.select(
//                Projections.fields(
//                        PostDTO.class,
//                        post.id,
//                        post.postTitle,
//                        post.postContent,
//                        ExpressionUtils.as(
//                            (JPAExpressions
//                                    .select(reply.id.count().intValue())
//                                    .from(reply)
//                                    .where(reply.post.id.eq(post.id).and(reply.depth.eq(1L))))
//                        , "replyCount")
//                )
//        ).from(post).fetch();
//    }
@Override
public Page<PostDTO> findAllWithReplyCount(Pageable pageable, PostSearch postSearch) {
//   BooleanExpression은 and로 연결할 때 사용한다.
//   where()에서 , 로 연결해준다.
    BooleanExpression postTitleContains = StringUtils.hasText(postSearch.getPostTitle()) ? null : post.postTitle.contains(postSearch.getPostTitle());
    BooleanExpression postContentContains = postSearch.getPostContent() == null ? null : post.postContent.contains(postSearch.getPostContent());
    BooleanExpression replyCountEqual =
            postSearch.getReplyCount() == null ? null :
                    JPAExpressions
                    .select(reply.id.count().intValue())
                    .from(reply)
                    .where(reply.post.id.eq(post.id).and(reply.depth.eq(1L))).eq(postSearch.getReplyCount());

//    BooleanBuilder는 and, or 모두 사용 가능하다.
//    where(builder)로 사용한다.
    BooleanBuilder builder = new BooleanBuilder();
    if(postContentContains != null){
        builder.or(postTitleContains);
    }
    if (postContentContains != null){
        builder.or(postContentContains);
    }
    if (postContentContains != null){
        builder.or(replyCountEqual);
    }

    final List<PostDTO> posts = query.select(
            Projections.fields(
                    PostDTO.class,
                    post.id,
                    post.postTitle,
                    post.postContent,
                    ExpressionUtils.as(
                            (JPAExpressions
                                    .select(reply.id.count().intValue())
                                    .from(reply)
                                    .where(reply.post.id.eq(post.id).and(reply.depth.eq(1L))))
                            , "replyCount")
            )
    ).from(post)
//            .where(postTitleContains, postContentContains, replyCountEqual)
            .where(builder)
            .fetch();

    final long count = query.select(post.count()).from(post).fetchOne();

    return new PageImpl<>(posts, pageable, count);
}


    @Override
    public Optional<Post> findPostById(Long id) {
        return Optional.ofNullable(query.selectFrom(post).where(post.id.eq(id)).fetchOne());
    }
}









