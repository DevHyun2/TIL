package com.shinhan.firstzone.vo3;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFreeBoardEntity is a Querydsl query type for FreeBoardEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFreeBoardEntity extends EntityPathBase<FreeBoardEntity> {

    private static final long serialVersionUID = -2056412905L;

    public static final QFreeBoardEntity freeBoardEntity = new QFreeBoardEntity("freeBoardEntity");

    public final NumberPath<Long> bno = createNumber("bno", Long.class);

    public final StringPath content = createString("content");

    public final DateTimePath<java.sql.Timestamp> regdate = createDateTime("regdate", java.sql.Timestamp.class);

    public final ListPath<FreeReplyEntity, QFreeReplyEntity> replies = this.<FreeReplyEntity, QFreeReplyEntity>createList("replies", FreeReplyEntity.class, QFreeReplyEntity.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    public final DateTimePath<java.sql.Timestamp> updatedate = createDateTime("updatedate", java.sql.Timestamp.class);

    public final StringPath writer = createString("writer");

    public QFreeBoardEntity(String variable) {
        super(FreeBoardEntity.class, forVariable(variable));
    }

    public QFreeBoardEntity(Path<? extends FreeBoardEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFreeBoardEntity(PathMetadata metadata) {
        super(FreeBoardEntity.class, metadata);
    }

}

