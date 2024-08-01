package com.shinhan.firstzone.vo3;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserVO3 is a Querydsl query type for UserVO3
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserVO3 extends EntityPathBase<UserVO3> {

    private static final long serialVersionUID = 1032696745L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserVO3 userVO3 = new QUserVO3("userVO3");

    public final QUserCellPhoneVO3 phone;

    public final StringPath userid = createString("userid");

    public final StringPath username = createString("username");

    public QUserVO3(String variable) {
        this(UserVO3.class, forVariable(variable), INITS);
    }

    public QUserVO3(Path<? extends UserVO3> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserVO3(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserVO3(PathMetadata metadata, PathInits inits) {
        this(UserVO3.class, metadata, inits);
    }

    public QUserVO3(Class<? extends UserVO3> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.phone = inits.isInitialized("phone") ? new QUserCellPhoneVO3(forProperty("phone"), inits.get("phone")) : null;
    }

}

