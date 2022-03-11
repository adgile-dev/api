package com.adgile.repository;

import com.adgile.domain.Media;
import com.adgile.domain.conditional.MediaConditional;
import com.adgile.dto.response.MediaInfoResponse;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.adgile.domain.QUser.user;
import static com.adgile.domain.QMedia.media;
import static org.springframework.util.StringUtils.hasText;

@RequiredArgsConstructor
public class MediaCustomImpl implements MediaCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<Media> findMedia(MediaConditional where) {
        return Optional.ofNullable(
                queryFactory.selectFrom(media)
                        .where(
                                eqId(where.getId()),
                                eqUserId(where.getUserId()),
                                eqName(where.getName()),
                                eqManager(where.getManager()),
                                eqEmail(where.getEmail()),
                                eqClickUrl(where.getClickUrl()),
                                eqInstallPostback(where.getInstallPostback()),
                                eqEventPostback(where.getEventPostback()),
                                media.deletedAt.isNull()
                        )
                        .fetchOne()
        );

    }

    @Override
    public Optional<Tuple> findMediaOfUser(MediaConditional where) {
        Optional<Tuple> t = Optional.ofNullable(
                queryFactory.select(media, user)
                        .from(media)
                        .leftJoin(user).on(user.id.eq(media.userId), user.deletedAt.isNull())
                        .where(
                                eqId(where.getId()),
                                eqUserId(where.getUserId()),
                                eqName(where.getName()),
                                eqManager(where.getManager()),
                                eqEmail(where.getEmail()),
                                eqClickUrl(where.getClickUrl()),
                                eqInstallPostback(where.getInstallPostback()),
                                eqEventPostback(where.getEventPostback()),
                                media.deletedAt.isNull()
                        )
                        .fetchOne()
        );
        return t;
    }

    private BooleanExpression eqId(Long id) {
        return id != null ? media.id.eq(id) : null;
    }

    private BooleanExpression eqUserId(Long id) {
        return id != null? media.userId.eq(id) : null;
    }

    private BooleanExpression eqName(String name) {
        return hasText(name) ? media.name.eq(name) : null;
    }

    private BooleanExpression eqManager(String manager) {
        return hasText(manager) ? media.manager.eq(manager) : null;
    }

    private BooleanExpression eqEmail(String email) {
        return hasText(email) ? media.email .eq(email) : null;
    }

    private BooleanExpression eqClickUrl(String url) {
        return hasText(url) ? media.clickUrl.eq(url) : null;
    }

    private BooleanExpression eqInstallPostback(String postback) {
        return hasText(postback) ? media.installPostback.eq(postback) : null;
    }

    private BooleanExpression eqEventPostback(String postback) {
        return hasText(postback) ? media.eventPostback.eq(postback) : null;
    }
}
