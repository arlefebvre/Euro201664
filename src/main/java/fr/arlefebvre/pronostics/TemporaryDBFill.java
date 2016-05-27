/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Arthur Lefebvre
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package fr.arlefebvre.pronostics;

import fr.arlefebvre.pronostics.model.Account;
import fr.arlefebvre.pronostics.model.Player;
import fr.arlefebvre.pronostics.repo.AccountRepository;
import fr.arlefebvre.pronostics.repo.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Arthur on 14/04/2016.
 */
@Component
public class TemporaryDBFill implements CommandLineRunner{

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public void run(String... strings) throws Exception {
        accountRepository.deleteAll();
        Account acc = new Account("toto","");
        accountRepository.save(acc);

        playerRepository.deleteAll();
        Player p = new Player();
        p.setName("Joueur 1");
        p.setMail("aa@aa.fr");
        p.setSheetId("567886786hdj4686486");
        playerRepository.save(p);
    }
}
