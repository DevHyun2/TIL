package com.shinhan.firstzone.vo3;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMultiKeyBClass is a Querydsl query type for MultiKeyBClass
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMultiKeyBClass extends EntityPathBase<MultiKeyBClass> {

    private static final long serialVersionUID = -1656276926L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMultiKeyBClass multiKeyBClass = new QMultiKeyBClass("multiKeyBClass");

    public final QMultiKeyB multib;

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final StringPath productName = createString("productName");

    public QMultiKeyBClass(String variable) {
        this(MultiKeyBClass.class, forVariable(variable), INITS);
    }

    public QMultiKeyBClass(Path<? extends MultiKeyBClass> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMultiKeyBClass(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMultiKeyBClass(PathMetadata metadata, PathInits inits) {
        this(MultiKeyBClass.class, metadata, inits);
    }

    public QMultiKeyBClass(Class<? extends MultiKeyBClass> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.multib = inits.isInitialized("multib") ? new QMultiKeyB(forProperty("multib")) : null;
    }

}

