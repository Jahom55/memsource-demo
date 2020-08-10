package com.memsource.demotestproject.setup;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Slf4j
@Repository
public class UserSetupQRepository implements UserRepository {

    private final JPAQueryFactory queryFactory;
    private final UserSetupJpaRepository jpaRepository;

    @Override
    public UserSetupDTO getFirstUsersSetup() {
        QUserSetupEntity userSetupEntity = QUserSetupEntity.userSetupEntity;

        return UserSetupConvertor.convert(queryFactory.select(userSetupEntity)
                .from(userSetupEntity)
                .fetchFirst());
    }

    @Override
    public UserSetupDTO findUserSetupByUsername(String username) {
        QUserSetupEntity userSetupEntity = QUserSetupEntity.userSetupEntity;

        return UserSetupConvertor.convert(queryFactory.select(userSetupEntity)
                .from(userSetupEntity)
                .where(userSetupEntity.username.eq(username))
                .fetchFirst());
    }


    @Override
    public void save(UserSetupDTO userSetup) {
        jpaRepository.save(UserSetupConvertor.convert(userSetup));
    }
}
