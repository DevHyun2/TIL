package com.shinhan.firstzone.vo2;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QGuestBookEntity is a Querydsl query type for GuestBookEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGuestBookEntity extends EntityPathBase<GuestBookEntity> {

    private static final long serialVersionUID = 437765853L;

    public static final QGuestBookEntity guestBookEntity = new QGuestBookEntity("guestBookEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath content = createString("content");

    public final NumberPath<Long> gno = createNumber("gno", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final StringPath title = createString("title");

    public final StringPath writer = createString("writer");

    public QGuestBookEntity(String variable) {
        super(GuestBookEntity.class, forVariable(variable));
    }

    public QGuestBookEntity(Path<? extends GuestBookEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGuestBookEntity(PathMetadata metadata) {
        super(GuestBookEntity.class, metadata);
    }

}

