package com.shinhan.firstzone.vo3;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFreeReplyEntity is a Querydsl query type for FreeReplyEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFreeReplyEntity extends EntityPathBase<FreeReplyEntity> {

    private static final long serialVersionUID = -528960997L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFreeReplyEntity freeReplyEntity = new QFreeReplyEntity("freeReplyEntity");

    public final QFreeBoardEntity board;

    public final DateTimePath<java.sql.Timestamp> regdate = createDateTime("regdate", java.sql.Timestamp.class);

    public final StringPath reply = createString("reply");

    public final StringPath replyer = createString("replyer");

    public final NumberPath<Long> rno = createNumber("rno", Long.class);

    public final DateTimePath<java.sql.Timestamp> updatedate = createDateTime("updatedate", java.sql.Timestamp.class);

    public QFreeReplyEntity(String variable) {
        this(FreeReplyEntity.class, forVariable(variable), INITS);
    }

    public QFreeReplyEntity(Path<? extends FreeReplyEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFreeReplyEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFreeReplyEntity(PathMetadata metadata, PathInits inits) {
        this(FreeReplyEntity.class, metadata, inits);
    }

    public QFreeReplyEntity(Class<? extends FreeReplyEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.board = inits.isInitialized("board") ? new QFreeBoardEntity(forProperty("board")) : null;
    }

}

