package live.greenmarket.user.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QReviewEntity is a Querydsl query type for ReviewEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewEntity extends EntityPathBase<ReviewEntity> {

    private static final long serialVersionUID = -297304049L;

    public static final QReviewEntity reviewEntity = new QReviewEntity("reviewEntity");

    public final StringPath comment = createString("comment");

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> memberId = createNumber("memberId", Integer.class);

    public final StringPath memberName = createString("memberName");

    public final NumberPath<Float> rating = createNumber("rating", Float.class);

    public final NumberPath<Integer> reservationId = createNumber("reservationId", Integer.class);

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public QReviewEntity(String variable) {
        super(ReviewEntity.class, forVariable(variable));
    }

    public QReviewEntity(Path<? extends ReviewEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReviewEntity(PathMetadata metadata) {
        super(ReviewEntity.class, metadata);
    }

}

