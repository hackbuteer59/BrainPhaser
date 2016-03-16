package de.fhdw.ergoholics.brainphaser.logic.statistics;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;

import java.util.ArrayList;
import java.util.List;

import de.fhdw.ergoholics.brainphaser.BrainPhaserApplication;
import de.fhdw.ergoholics.brainphaser.R;
import de.fhdw.ergoholics.brainphaser.database.ChallengeDataSource;
import de.fhdw.ergoholics.brainphaser.database.CompletionDataSource;
import de.fhdw.ergoholics.brainphaser.database.StatisticsDataSource;
import de.fhdw.ergoholics.brainphaser.logic.UserLogicFactory;
import de.fhdw.ergoholics.brainphaser.model.User;

/**
 * Created by Daniel Hoogen on 05/03/2016.
 *
 * This class contains the logic for creating statistics about due challenges and challenge stages
 */
public class StatisticsLogic {
    //Attributes
    private BrainPhaserApplication mApplication ;
    private ChartSettings mSettings;
    private ChartDataLogic mDataLogic;

    //Constructor
    public StatisticsLogic(User user, long categoryId, BrainPhaserApplication application, ChallengeDataSource challengeDataSource, CompletionDataSource completionDataSource, StatisticsDataSource statisticsDataSource, UserLogicFactory userLogicFactory) {
        mApplication = application;

        mSettings = new ChartSettings(application);
        mDataLogic = new ChartDataLogic(user, categoryId, application, userLogicFactory, challengeDataSource, completionDataSource, statisticsDataSource);
    }

    /**
     * Creates a PieData object containing entries with the numbers of due and not due challenges.
     * @param chart the PieChart object the calculated data will be applied to
     * @param type the type of the statistic to be created
     * @return a list of the ids of the shown challenges, if a most played / failed / succeeded
     * challenges chart is created. Otherwise null will be returned.
     */
    public List<Long> fillChart(PieChart chart, StatisticType type) {
        if (chart==null)
            return null;

        //Clear the chart for reloading
        chart.clear();

        //Create chart data
        List<Long> shownChallenges = new ArrayList<>();
        PieData data;

        //Find chart data and apply type specific settings
        switch (type) {
            case TYPE_DUE:
                data = mDataLogic.findDueData();
                chart.setCenterText(mApplication.getString(R.string.due_chart_center_text));
                break;
            case TYPE_STAGE:
                data = mDataLogic.findStageData();
                chart.setCenterText(mApplication.getString(R.string.stage_chart_center_text));
                break;
            default:
                data = mDataLogic.findMostPlayedData(type, shownChallenges);
                chart.setCenterText("");
                chart.getLegend().setEnabled(false);
        }

        if (data != null) {
            //Add data to chart
            chart.setData(data);

            //Apply default chart settings to the chart
            mSettings.applyChartSettings(chart);
        }
        else
            //Format the no data text of the chart
            mSettings.applyNoDataSettings(chart);

        //If there are shown challenges in the List object return the List object, else return null
        return (shownChallenges.size() > 0) ? shownChallenges : null;
    }
}