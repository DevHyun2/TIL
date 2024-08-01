package com.shinhan.firstzone.vo3;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserCellPhoneVO2 is a Querydsl query type for UserCellPhoneVO2
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserCellPhoneVO2 extends EntityPathBase<UserCellPhoneVO2> {

    private static final long serialVersionUID = 837143006L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserCellPhoneVO2 userCellPhoneVO2 = new QUserCellPhoneVO2("userCellPhoneVO2");

    public final StringPath model = createString("model");

    public final NumberPath<Long> phoneId = createNumber("phoneId", Long.class);

    public final StringPath phoneNumber = createString("phoneNumber");

    public final QUserVO2 user;

    public QUserCellPhoneVO2(String variable) {
        this(UserCellPhoneVO2.class, forVariable(variable), INITS);
    }

    public QUserCellPhoneVO2(Path<? extends UserCellPhoneVO2> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserCellPhoneVO2(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserCellPhoneVO2(PathMetadata metadata, PathInits inits) {
        this(UserCellPhoneVO2.class, metadata, inits);
    }

    public QUserCellPhoneVO2(Class<? extends UserCellPhoneVO2> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUserVO2(forProperty("user")) : null;
    }

}

