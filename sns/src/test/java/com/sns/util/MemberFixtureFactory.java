package com.sns.util;

import com.sns.domain.member.entity.Member;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;


public class MemberFixtureFactory {
    static public Member create() {
        var param = new EasyRandomParameters();
        return new EasyRandom(param).nextObject(Member.class);
    }


    static public Member create(Long seed) {
        var param = new EasyRandomParameters().seed(seed);
        return new EasyRandom(param).nextObject(Member.class);
    }

}
