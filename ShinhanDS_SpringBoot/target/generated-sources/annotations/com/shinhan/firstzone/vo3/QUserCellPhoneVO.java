package com.shinhan.firstzone.vo3;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserCellPhoneVO is a Querydsl query type for UserCellPhoneVO
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserCellPhoneVO extends EntityPathBase<UserCellPhoneVO> {

    private static final long serialVersionUID = 581193940L;

    public static final QUserCellPhoneVO userCellPhoneVO = new QUserCellPhoneVO("userCellPhoneVO");

    public final StringPath model = createString("model");

    public final NumberPath<Long> phoneId = createNumber("phoneId", Long.class);

    public final StringPath phoneNumber = createString("phoneNumber");

    public QUserCellPhoneVO(String variable) {
        super(UserCellPhoneVO.class, forVariable(variable));
    }

    public QUserCellPhoneVO(Path<? extends UserCellPhoneVO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserCellPhoneVO(PathMetadata metadata) {
        super(UserCellPhoneVO.class, metadata);
    }

}

