package com.shinhan.firstzone.vo3;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserVO is a Querydsl query type for UserVO
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserVO extends EntityPathBase<UserVO> {

    private static final long serialVersionUID = 1557333450L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserVO userVO = new QUserVO("userVO");

    public final QUserCellPhoneVO phone;

    public final StringPath userid = createString("userid");

    public final StringPath username = createString("username");

    public QUserVO(String variable) {
        this(UserVO.class, forVariable(variable), INITS);
    }

    public QUserVO(Path<? extends UserVO> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserVO(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserVO(PathMetadata metadata, PathInits inits) {
        this(UserVO.class, metadata, inits);
    }

    public QUserVO(Class<? extends UserVO> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.phone = inits.isInitialized("phone") ? new QUserCellPhoneVO(forProperty("phone")) : null;
    }

}

