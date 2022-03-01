package com.adgile.domain.repository;

import com.adgile.domain.User;
import com.adgile.dto.conditional.UserConditional;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.adgile.domain.QUser.user;

@RequiredArgsConstructor
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<User> findUser(UserConditional where) {

        return Optional.ofNullable(
                queryFactory.selectFrom(user)
                        .where(
                                eqId(where.getId())
                        )
                        .fetchOne()
        );
    }

    private BooleanExpression eqId(Long id) {
        return id != null ? user.id.eq(id) : null;
    }
}
