package com.shinhan.firstzone.vo2;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProfileEntity is a Querydsl query type for ProfileEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProfileEntity extends EntityPathBase<ProfileEntity> {

    private static final long serialVersionUID = -248855579L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProfileEntity profileEntity = new QProfileEntity("profileEntity");

    public final BooleanPath currentYn = createBoolean("currentYn");

    public final StringPath fname = createString("fname");

    public final NumberPath<Long> fno = createNumber("fno", Long.class);

    public final QMemberEntity member;

    public QProfileEntity(String variable) {
        this(ProfileEntity.class, forVariable(variable), INITS);
    }

    public QProfileEntity(Path<? extends ProfileEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProfileEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProfileEntity(PathMetadata metadata, PathInits inits) {
        this(ProfileEntity.class, metadata, inits);
    }

    public QProfileEntity(Class<? extends ProfileEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMemberEntity(forProperty("member")) : null;
    }

}

