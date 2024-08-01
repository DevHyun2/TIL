package com.shinhan.firstzone.vo3;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMultiKeyB is a Querydsl query type for MultiKeyB
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QMultiKeyB extends BeanPath<MultiKeyB> {

    private static final long serialVersionUID = -1253157162L;

    public static final QMultiKeyB multiKeyB = new QMultiKeyB("multiKeyB");

    public final NumberPath<Integer> id1 = createNumber("id1", Integer.class);

    public final NumberPath<Integer> id2 = createNumber("id2", Integer.class);

    public QMultiKeyB(String variable) {
        super(MultiKeyB.class, forVariable(variable));
    }

    public QMultiKeyB(Path<? extends MultiKeyB> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMultiKeyB(PathMetadata metadata) {
        super(MultiKeyB.class, metadata);
    }

}

