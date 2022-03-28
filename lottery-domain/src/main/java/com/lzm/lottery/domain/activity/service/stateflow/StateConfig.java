package com.lzm.lottery.domain.activity.service.stateflow;

import com.lzm.lottery.common.Constants;
import com.lzm.lottery.domain.activity.service.stateflow.event.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StateConfig {
    @Resource
    private CommitState commitState;
    @Resource
    private CloseState closeState;
    @Resource
    private UndergoState undergoState;
    @Resource
    private EditingState editingState;
    @Resource
    private OpenState openState;
    @Resource
    private PassState passState;
    @Resource
    private RefuseState refuseState;

    protected Map< Enum<Constants.ActivityState>, AbstractState> stateMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        stateMap.put(Constants.ActivityState.Commit, commitState);
        stateMap.put(Constants.ActivityState.CLOSE, closeState);
        stateMap.put(Constants.ActivityState.EDIT, editingState);
        stateMap.put(Constants.ActivityState.UNDERGO, undergoState);
        stateMap.put(Constants.ActivityState.OPEN, openState);
        stateMap.put(Constants.ActivityState.PASS, passState);
        stateMap.put(Constants.ActivityState.REFUSE, refuseState);
    }

}
