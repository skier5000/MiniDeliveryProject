package org.minideliveryproject.application.domain.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@SpringBootTest
@Transactional
public class DbQueryDslTest {



    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.baeldung.querydsl.intro");
    EntityManager em = emf.createEntityManager();
//    JPAQueryFactory queryFactory = new JPAQueryFactory(em);

    /*
QueryDSL 테스트
*/
//    @Test
//    public void group() throws Exception {
//        List<Tuple> fetch =
//                queryFactory.select(team.name, member.age.avg())
//                        .from(member)
//                        .join(member.team, team)
//                        .groupBy(team.name)
//                        .fetch();
//
//        Tuple teamA = fetch.get(0);
//        Tuple teamB = fetch.get(1);
//
//        assertThat(teamA.get(team.name)).isEqualTo("TEAM A");
//        assertThat(teamA.get(member.age.avg())).isEqualTo(15);
//
//        assertThat(teamB.get(team.name)).isEqualTo("TEAM B");
//        assertThat(teamB.get(member.age.avg())).isEqualTo(35);
//    }
}
