package com.shinhan.firstzone.vo2;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPDSBoardEntity is a Querydsl query type for PDSBoardEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPDSBoardEntity extends EntityPathBase<PDSBoardEntity> {

    private static final long serialVersionUID = 1407009297L;

    public static final QPDSBoardEntity pDSBoardEntity = new QPDSBoardEntity("pDSBoardEntity");

    public final ListPath<PDSFileEntity, QPDSFileEntity> files = this.<PDSFileEntity, QPDSFileEntity>createList("files", PDSFileEntity.class, QPDSFileEntity.class, PathInits.DIRECT2);

    public final NumberPath<Long> pid = createNumber("pid", Long.class);

    public final StringPath pname = createString("pname");

    public final StringPath writer = createString("writer");

    public QPDSBoardEntity(String variable) {
        super(PDSBoardEntity.class, forVariable(variable));
    }

    public QPDSBoardEntity(Path<? extends PDSBoardEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPDSBoardEntity(PathMetadata metadata) {
        super(PDSBoardEntity.class, metadata);
    }

}

