package com.kii.thingifsample.uimodel;

import com.kii.thingifsample.R;

public class NotEquals extends Clause {

    private com.kii.thingif.trigger.clause.NotEquals clause;

    @Override
    public int getIcon() {
        return R.drawable.ic_code_not_equal_black_36dp;
    }
    @Override
    public ClauseType getType() {
        return ClauseType.NOT_EQUALS;
    }
    @Override
    public String getSummary() {
        if (this.clause == null) {
            return "Not Equals";
        }
        return this.clause.getEquals().getField() + " != " + this.clause.getEquals().getValue().toString();
    }
    @Override
    public com.kii.thingif.trigger.clause.Clause getClause() {
        return this.clause;
    }
    @Override
    public void setClause(com.kii.thingif.trigger.clause.Clause clause) {
        this.clause = (com.kii.thingif.trigger.clause.NotEquals)clause;
    }
}
