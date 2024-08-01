package com.shinhan.firstzone.vo3;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEnumTypeVO is a Querydsl query type for EnumTypeVO
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEnumTypeVO extends EntityPathBase<EnumTypeVO> {

    private static final long serialVersionUID = 1470632666L;

    public static final QEnumTypeVO enumTypeVO = new QEnumTypeVO("enumTypeVO");

    public final StringPath mid = createString("mid");

    public final StringPath mname = createString("mname");

    public final StringPath mpassword = createString("mpassword");

    public final SetPath<com.shinhan.firstzone.vo2.MemberRole, EnumPath<com.shinhan.firstzone.vo2.MemberRole>> mrole = this.<com.shinhan.firstzone.vo2.MemberRole, EnumPath<com.shinhan.firstzone.vo2.MemberRole>>createSet("mrole", com.shinhan.firstzone.vo2.MemberRole.class, EnumPath.class, PathInits.DIRECT2);

    public QEnumTypeVO(String variable) {
        super(EnumTypeVO.class, forVariable(variable));
    }

    public QEnumTypeVO(Path<? extends EnumTypeVO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEnumTypeVO(PathMetadata metadata) {
        super(EnumTypeVO.class, metadata);
    }

}

