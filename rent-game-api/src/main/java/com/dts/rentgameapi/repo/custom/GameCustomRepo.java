package com.dts.rentgameapi.repo.custom;

import com.dts.rentgameapi.domain.dto.mapping.GameDetailMapping;
import com.dts.rentgameapi.domain.dto.mapping.GameFormMapping;
import com.dts.rentgameapi.domain.dto.mapping.GameOwnerPlayedMapping;
import com.dts.rentgameapi.domain.entity.TblGameEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GameCustomRepo extends BaseCustomRepo {
    public List<GameOwnerPlayedMapping> findGamesOwner(int user_id, int start, int limit, String sort, Integer store_id, Integer category_id) {
        List<GameOwnerPlayedMapping> gameSliders = null;
        StringBuilder builder = new StringBuilder();

        //  builder.append("select * from  ezplay.tbl_game  LEFT JOIN  (SELECT * FROM tbl_user_game_info WHERE user_id= " + user_id + ") as A ON  tbl_game.id=A.game_id ");
        builder.append("select * from  tbl_game INNER JOIN tbl_shop_games  ON  tbl_game.id=tbl_shop_games.game_id LEFT JOIN  (SELECT * FROM tbl_user_game_info WHERE user_id= " + user_id + ") as A ON  tbl_game.id=A.game_id ");

        boolean flag = false;
        if (store_id > 0 || category_id > 0) {
            builder.append("where ");
            if (store_id > 0) {
                builder.append(" store_id = " + store_id);
                flag = true;
            }
            if (category_id > 0) {
                if (flag)
                    builder.append(" and category_id = " + category_id);
                else
                    builder.append("category_id = " + category_id);
            }
        }
        if (sort != null && sort.equalsIgnoreCase("desc") || sort.equalsIgnoreCase("asc"))
            builder.append(" ORDER BY tbl_game.updated_at " + sort);
        builder.append(" limit " + start + "," + limit);
        try {
            Query query = this.entityManager.createNativeQuery(builder.toString(),"GameOwnerPlayedMapping");
            gameSliders = query.getResultList();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return gameSliders;
    }


    public List<TblGameEntity> findGames(Integer start, Integer limit, String sort, Integer store_id, Integer category_id) {
        List<TblGameEntity> gameEntities = null;
        StringBuilder builder = new StringBuilder();
        builder.append("select * from  tbl_game ");
        if (store_id > 0 || category_id > 0) {
            builder.append("where ");
            boolean flag = false;
            if (store_id > 0) {
                builder.append("store_id = " + store_id);
                flag = true;
            }
            if (category_id > 0) {
                if (flag)
                    builder.append(" and category_id = " + category_id);
                else
                    builder.append("category_id = " + category_id);
            }
        }
        if (sort != null && sort.equalsIgnoreCase("desc") || sort.equalsIgnoreCase("asc"))
            builder.append(" ORDER BY tbl_game.updated_at " + sort);
        builder.append(" limit " + start + "," + limit);
        try {
            Query query = this.entityManager.createNativeQuery(builder.toString(), TblGameEntity.class);
            gameEntities = query.getResultList();
        } catch (Exception e) {
            logger.error(e.getMessage(), e.getCause());
        }
        return gameEntities;
    }


    public GameDetailMapping findById(Integer id) {
        GameDetailMapping gameDetailEntity =null;
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT a.*,b.shop_id,c.shop_name,c.alias FROM tbl_game a inner join tbl_shop_games b on a.id=b.game_id ");
        builder.append("inner join tbl_shop c on b.shop_id=c.id where a.id=" + id);
        try {
            Query query = this.entityManager.createNativeQuery(builder.toString(),"GameDetailMapping");
            gameDetailEntity = (GameDetailMapping) query.getSingleResult();
        } catch (Exception e) {
            logger.error(e.getMessage(), e.getCause());
        }
        return gameDetailEntity;
    }


    public List<GameFormMapping> findByTopPlay(Integer limit) {
        List<GameFormMapping> gameFormEntities = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT * FROM tbl_shop_games a inner join tbl_game b on a.game_id=b.id ORDER BY play_count desc limit " + limit);
        try {
            Query query = this.entityManager.createNativeQuery(builder.toString(), "GameFormMapping");
            gameFormEntities = query.getResultList();
        } catch (Exception e) {
            logger.error(e.getMessage(), e.getCause());
        }
        return gameFormEntities;
    }

    public List<GameFormMapping> findByTopNewest(Integer limit) {
        List<GameFormMapping> gameFormEntities = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT * FROM tbl_game a inner join tbl_shop_games b on a.id=b.game_id ORDER BY updated_at desc limit " + limit);
        try {
            Query query = this.entityManager.createNativeQuery(builder.toString(), "GameFormMapping");
            gameFormEntities = query.getResultList();
        } catch (Exception e) {
            logger.error(e.getMessage(), e.getCause());
        }
        return gameFormEntities;
    }
}
