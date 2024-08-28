package live.greenmarket.user.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QHotelEntity is a Querydsl query type for HotelEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHotelEntity extends EntityPathBase<HotelEntity> {

    private static final long serialVersionUID = -692143741L;

    public static final QHotelEntity hotelEntity = new QHotelEntity("hotelEntity");

    public final StringPath content = createString("content");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> memberId = createNumber("memberId", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath providerName = createString("providerName");

    public final NumberPath<Float> rating = createNumber("rating", Float.class);

    public final StringPath tel = createString("tel");

    public QHotelEntity(String variable) {
        super(HotelEntity.class, forVariable(variable));
    }

    public QHotelEntity(Path<? extends HotelEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHotelEntity(PathMetadata metadata) {
        super(HotelEntity.class, metadata);
    }

}

