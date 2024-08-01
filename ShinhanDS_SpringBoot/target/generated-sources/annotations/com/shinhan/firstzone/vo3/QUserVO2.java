package com.shinhan.firstzone.vo3;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserVO2 is a Querydsl query type for UserVO2
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserVO2 extends EntityPathBase<UserVO2> {

    private static final long serialVersionUID = 1032696744L;

    public static final QUserVO2 userVO2 = new QUserVO2("userVO2");

    public final StringPath userid = createString("userid");

    public final StringPath username = createString("username");

    public QUserVO2(String variable) {
        super(UserVO2.class, forVariable(variable));
    }

    public QUserVO2(Path<? extends UserVO2> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserVO2(PathMetadata metadata) {
        super(UserVO2.class, metadata);
    }

}

