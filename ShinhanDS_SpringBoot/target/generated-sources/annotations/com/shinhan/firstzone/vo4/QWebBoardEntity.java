package com.shinhan.firstzone.vo4;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWebBoardEntity is a Querydsl query type for WebBoardEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWebBoardEntity extends EntityPathBase<WebBoardEntity> {

    private static final long serialVersionUID = 1985874010L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWebBoardEntity webBoardEntity = new QWebBoardEntity("webBoardEntity");

    public final NumberPath<Long> bno = createNumber("bno", Long.class);

    public final StringPath content = createString("content");

    public final DateTimePath<java.sql.Timestamp> regdate = createDateTime("regdate", java.sql.Timestamp.class);

    public final ListPath<WebReplyEntity, QWebReplyEntity> replies = this.<WebReplyEntity, QWebReplyEntity>createList("replies", WebReplyEntity.class, QWebReplyEntity.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    public final DateTimePath<java.sql.Timestamp> updatedate = createDateTime("updatedate", java.sql.Timestamp.class);

    public final com.shinhan.firstzone.vo2.QMemberEntity writer;

    public QWebBoardEntity(String variable) {
        this(WebBoardEntity.class, forVariable(variable), INITS);
    }

    public QWebBoardEntity(Path<? extends WebBoardEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QWebBoardEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QWebBoardEntity(PathMetadata metadata, PathInits inits) {
        this(WebBoardEntity.class, metadata, inits);
    }

    public QWebBoardEntity(Class<? extends WebBoardEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.writer = inits.isInitialized("writer") ? new com.shinhan.firstzone.vo2.QMemberEntity(forProperty("writer")) : null;
    }

}

