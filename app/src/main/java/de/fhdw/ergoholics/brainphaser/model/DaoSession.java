package de.fhdw.ergoholics.brainphaser.model;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import de.fhdw.ergoholics.brainphaser.model.User;
import de.fhdw.ergoholics.brainphaser.model.Category;
import de.fhdw.ergoholics.brainphaser.model.Challenge;
import de.fhdw.ergoholics.brainphaser.model.Answer;
import de.fhdw.ergoholics.brainphaser.model.Completion;
import de.fhdw.ergoholics.brainphaser.model.Settings;

import de.fhdw.ergoholics.brainphaser.model.UserDao;
import de.fhdw.ergoholics.brainphaser.model.CategoryDao;
import de.fhdw.ergoholics.brainphaser.model.ChallengeDao;
import de.fhdw.ergoholics.brainphaser.model.AnswerDao;
import de.fhdw.ergoholics.brainphaser.model.CompletionDao;
import de.fhdw.ergoholics.brainphaser.model.SettingsDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userDaoConfig;
    private final DaoConfig categoryDaoConfig;
    private final DaoConfig challengeDaoConfig;
    private final DaoConfig answerDaoConfig;
    private final DaoConfig completionDaoConfig;
    private final DaoConfig settingsDaoConfig;

    private final UserDao userDao;
    private final CategoryDao categoryDao;
    private final ChallengeDao challengeDao;
    private final AnswerDao answerDao;
    private final CompletionDao completionDao;
    private final SettingsDao settingsDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        categoryDaoConfig = daoConfigMap.get(CategoryDao.class).clone();
        categoryDaoConfig.initIdentityScope(type);

        challengeDaoConfig = daoConfigMap.get(ChallengeDao.class).clone();
        challengeDaoConfig.initIdentityScope(type);

        answerDaoConfig = daoConfigMap.get(AnswerDao.class).clone();
        answerDaoConfig.initIdentityScope(type);

        completionDaoConfig = daoConfigMap.get(CompletionDao.class).clone();
        completionDaoConfig.initIdentityScope(type);

        settingsDaoConfig = daoConfigMap.get(SettingsDao.class).clone();
        settingsDaoConfig.initIdentityScope(type);

        userDao = new UserDao(userDaoConfig, this);
        categoryDao = new CategoryDao(categoryDaoConfig, this);
        challengeDao = new ChallengeDao(challengeDaoConfig, this);
        answerDao = new AnswerDao(answerDaoConfig, this);
        completionDao = new CompletionDao(completionDaoConfig, this);
        settingsDao = new SettingsDao(settingsDaoConfig, this);

        registerDao(User.class, userDao);
        registerDao(Category.class, categoryDao);
        registerDao(Challenge.class, challengeDao);
        registerDao(Answer.class, answerDao);
        registerDao(Completion.class, completionDao);
        registerDao(Settings.class, settingsDao);
    }
    
    public void clear() {
        userDaoConfig.getIdentityScope().clear();
        categoryDaoConfig.getIdentityScope().clear();
        challengeDaoConfig.getIdentityScope().clear();
        answerDaoConfig.getIdentityScope().clear();
        completionDaoConfig.getIdentityScope().clear();
        settingsDaoConfig.getIdentityScope().clear();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public CategoryDao getCategoryDao() {
        return categoryDao;
    }

    public ChallengeDao getChallengeDao() {
        return challengeDao;
    }

    public AnswerDao getAnswerDao() {
        return answerDao;
    }

    public CompletionDao getCompletionDao() {
        return completionDao;
    }

    public SettingsDao getSettingsDao() {
        return settingsDao;
    }

}
