<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="vip1App.replyVisitDataStat.home.createOrEditLabel" v-text="$t('vip1App.replyVisitDataStat.home.createOrEditLabel')">Create or edit a ReplyVisitDataStat</h2>
                <div>
                    <div class="form-group" v-if="replyVisitDataStat.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="replyVisitDataStat.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.replyVisitDataStat.clickCount')" for="reply-visit-data-stat-clickCount">Click Count</label>
                        <input type="number" class="form-control" name="clickCount" id="reply-visit-data-stat-clickCount"
                            :class="{'valid': !$v.replyVisitDataStat.clickCount.$invalid, 'invalid': $v.replyVisitDataStat.clickCount.$invalid }" v-model.number="$v.replyVisitDataStat.clickCount.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.replyVisitDataStat.startDate')" for="reply-visit-data-stat-startDate">Start Date</label>
                        <div class="input-group">
                            <input id="reply-visit-data-stat-startDate" type="date" class="form-control" name="startDate"  :class="{'valid': !$v.replyVisitDataStat.startDate.$invalid, 'invalid': $v.replyVisitDataStat.startDate.$invalid }"
                            v-model="$v.replyVisitDataStat.startDate.$model"  />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.replyVisitDataStat.endDate')" for="reply-visit-data-stat-endDate">End Date</label>
                        <div class="input-group">
                            <input id="reply-visit-data-stat-endDate" type="date" class="form-control" name="endDate"  :class="{'valid': !$v.replyVisitDataStat.endDate.$invalid, 'invalid': $v.replyVisitDataStat.endDate.$invalid }"
                            v-model="$v.replyVisitDataStat.endDate.$model"  />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.replyVisitDataStat.source')" for="reply-visit-data-stat-source">Source</label>
                        <select class="form-control" name="source" :class="{'valid': !$v.replyVisitDataStat.source.$invalid, 'invalid': $v.replyVisitDataStat.source.$invalid }" v-model="$v.replyVisitDataStat.source.$model" id="reply-visit-data-stat-source" >
                            <option value="SEARCH" v-bind:label="$t('vip1App.VisitSource.SEARCH')">SEARCH</option>
                            <option value="LIST" v-bind:label="$t('vip1App.VisitSource.LIST')">LIST</option>
                            <option value="PUSH" v-bind:label="$t('vip1App.VisitSource.PUSH')">PUSH</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.replyVisitDataStat.termimal')" for="reply-visit-data-stat-termimal">Termimal</label>
                        <input type="text" class="form-control" name="termimal" id="reply-visit-data-stat-termimal"
                            :class="{'valid': !$v.replyVisitDataStat.termimal.$invalid, 'invalid': $v.replyVisitDataStat.termimal.$invalid }" v-model="$v.replyVisitDataStat.termimal.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.replyVisitDataStat.replyCount')" for="reply-visit-data-stat-replyCount">Reply Count</label>
                        <input type="number" class="form-control" name="replyCount" id="reply-visit-data-stat-replyCount"
                            :class="{'valid': !$v.replyVisitDataStat.replyCount.$invalid, 'invalid': $v.replyVisitDataStat.replyCount.$invalid }" v-model.number="$v.replyVisitDataStat.replyCount.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.replyVisitDataStat.starCount')" for="reply-visit-data-stat-starCount">Star Count</label>
                        <input type="number" class="form-control" name="starCount" id="reply-visit-data-stat-starCount"
                            :class="{'valid': !$v.replyVisitDataStat.starCount.$invalid, 'invalid': $v.replyVisitDataStat.starCount.$invalid }" v-model.number="$v.replyVisitDataStat.starCount.$model" />
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.replyVisitDataStat.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./reply-visit-data-stat-update.component.ts">
</script>
