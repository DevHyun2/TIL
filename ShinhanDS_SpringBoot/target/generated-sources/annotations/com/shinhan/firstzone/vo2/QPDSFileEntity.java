package com.shinhan.firstzone.vo2;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPDSFileEntity is a Querydsl query type for PDSFileEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPDSFileEntity extends EntityPathBase<PDSFileEntity> {

    private static final long serialVersionUID = -1123197993L;

    public static final QPDSFileEntity pDSFileEntity = new QPDSFileEntity("pDSFileEntity");

    public final NumberPath<Long> fno = createNumber("fno", Long.class);

    public final StringPath pdsfilename = createString("pdsfilename");

    public QPDSFileEntity(String variable) {
        super(PDSFileEntity.class, forVariable(variable));
    }

    public QPDSFileEntity(Path<? extends PDSFileEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPDSFileEntity(PathMetadata metadata) {
        super(PDSFileEntity.class, metadata);
    }

}

