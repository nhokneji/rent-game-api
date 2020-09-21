package com.dts.rentgameapi.refactor;

import com.dts.rentgameapi.domain.entity.TblCashoutHistoryEntity;
import com.dts.rentgameapi.repo.CashoutHistoryRepo;
import com.dts.rentgameapi.repo.custom.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Iterator;

/**
 * @author Rin-DTS
 */
@Component
public class Refactor implements CommandLineRunner {


    @Autowired
    private CashoutHistoryRepo cashoutHistoryRepo;

 @Autowired
    private GameCustomRepo gameCustomRepo;

 @Autowired
    private GameSliderRepo gameSliderRepo;

 @Autowired
 private GameAccountCustomRepo gameAccountCustomRepo;
 @Autowired
 private RentGameHistoryCustomRepo rentGameHistoryCustomRepo;
@Autowired
 private UserGameInfoCustomRepo userGameInfoCustomRepo;



    @Override
    public void run(String... args) throws Exception {
      //Iterable<TblCashoutHistoryEntity> cashoutHistoryEntityIterator= cashoutHistoryRepo.findAll();
       // gameAccountCustomRepo.findGameAccountByShopId(4,0,10);
      //  gameSliderRepo.findAll();
       // gameCustomRepo.findById(3);
       // gameCustomRepo.findGamesOwner(4,0,10,"asc",-1,-1);

//        gameCustomRepo.findByTopNewest(10);
//        rentGameHistoryCustomRepo.rentGameByShopId(4,0,10);
//        userGameInfoCustomRepo.findByGameStore(5,0,10);

     //   System.out.println("dfsd");

    }
}
