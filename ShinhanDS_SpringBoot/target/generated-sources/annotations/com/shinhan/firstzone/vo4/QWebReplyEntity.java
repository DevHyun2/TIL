package com.shinhan.firstzone.vo4;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWebReplyEntity is a Querydsl query type for WebReplyEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWebReplyEntity extends EntityPathBase<WebReplyEntity> {

    private static final long serialVersionUID = -781641378L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWebReplyEntity webReplyEntity = new QWebReplyEntity("webReplyEntity");

    public final QWebBoardEntity board;

    public final DateTimePath<java.sql.Timestamp> regdate = createDateTime("regdate", java.sql.Timestamp.class);

    public final StringPath reply = createString("reply");

    public final StringPath replyer = createString("replyer");

    public final NumberPath<Long> rno = createNumber("rno", Long.class);

    public final DateTimePath<java.sql.Timestamp> updatedate = createDateTime("updatedate", java.sql.Timestamp.class);

    public QWebReplyEntity(String variable) {
        this(WebReplyEntity.class, forVariable(variable), INITS);
    }

    public QWebReplyEntity(Path<? extends WebReplyEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QWebReplyEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QWebReplyEntity(PathMetadata metadata, PathInits inits) {
        this(WebReplyEntity.class, metadata, inits);
    }

    public QWebReplyEntity(Class<? extends WebReplyEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.board = inits.isInitialized("board") ? new QWebBoardEntity(forProperty("board"), inits.get("board")) : null;
    }

}

