package com.shinhan.firstzone.vo3;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserCellPhoneVO3 is a Querydsl query type for UserCellPhoneVO3
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserCellPhoneVO3 extends EntityPathBase<UserCellPhoneVO3> {

    private static final long serialVersionUID = 837143007L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserCellPhoneVO3 userCellPhoneVO3 = new QUserCellPhoneVO3("userCellPhoneVO3");

    public final StringPath model = createString("model");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final QUserVO3 user3;

    public final StringPath userAA = createString("userAA");

    public QUserCellPhoneVO3(String variable) {
        this(UserCellPhoneVO3.class, forVariable(variable), INITS);
    }

    public QUserCellPhoneVO3(Path<? extends UserCellPhoneVO3> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserCellPhoneVO3(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserCellPhoneVO3(PathMetadata metadata, PathInits inits) {
        this(UserCellPhoneVO3.class, metadata, inits);
    }

    public QUserCellPhoneVO3(Class<? extends UserCellPhoneVO3> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user3 = inits.isInitialized("user3") ? new QUserVO3(forProperty("user3"), inits.get("user3")) : null;
    }

}

