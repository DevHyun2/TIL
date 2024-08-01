package com.shinhan.firstzone.vo3;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMultiKeyAClass is a Querydsl query type for MultiKeyAClass
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMultiKeyAClass extends EntityPathBase<MultiKeyAClass> {

    private static final long serialVersionUID = -1684906077L;

    public static final QMultiKeyAClass multiKeyAClass = new QMultiKeyAClass("multiKeyAClass");

    public final NumberPath<Integer> id1 = createNumber("id1", Integer.class);

    public final NumberPath<Integer> id2 = createNumber("id2", Integer.class);

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final StringPath productName = createString("productName");

    public QMultiKeyAClass(String variable) {
        super(MultiKeyAClass.class, forVariable(variable));
    }

    public QMultiKeyAClass(Path<? extends MultiKeyAClass> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMultiKeyAClass(PathMetadata metadata) {
        super(MultiKeyAClass.class, metadata);
    }

}

