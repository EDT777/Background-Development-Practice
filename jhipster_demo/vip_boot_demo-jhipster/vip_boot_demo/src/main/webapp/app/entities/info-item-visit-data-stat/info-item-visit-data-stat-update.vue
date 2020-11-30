<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="vip1App.infoItemVisitDataStat.home.createOrEditLabel" v-text="$t('vip1App.infoItemVisitDataStat.home.createOrEditLabel')">Create or edit a InfoItemVisitDataStat</h2>
                <div>
                    <div class="form-group" v-if="infoItemVisitDataStat.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="infoItemVisitDataStat.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.infoItemVisitDataStat.clickCount')" for="info-item-visit-data-stat-clickCount">Click Count</label>
                        <input type="number" class="form-control" name="clickCount" id="info-item-visit-data-stat-clickCount"
                            :class="{'valid': !$v.infoItemVisitDataStat.clickCount.$invalid, 'invalid': $v.infoItemVisitDataStat.clickCount.$invalid }" v-model.number="$v.infoItemVisitDataStat.clickCount.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.infoItemVisitDataStat.startDate')" for="info-item-visit-data-stat-startDate">Start Date</label>
                        <div class="input-group">
                            <input id="info-item-visit-data-stat-startDate" type="date" class="form-control" name="startDate"  :class="{'valid': !$v.infoItemVisitDataStat.startDate.$invalid, 'invalid': $v.infoItemVisitDataStat.startDate.$invalid }"
                            v-model="$v.infoItemVisitDataStat.startDate.$model"  />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.infoItemVisitDataStat.endDate')" for="info-item-visit-data-stat-endDate">End Date</label>
                        <div class="input-group">
                            <input id="info-item-visit-data-stat-endDate" type="date" class="form-control" name="endDate"  :class="{'valid': !$v.infoItemVisitDataStat.endDate.$invalid, 'invalid': $v.infoItemVisitDataStat.endDate.$invalid }"
                            v-model="$v.infoItemVisitDataStat.endDate.$model"  />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.infoItemVisitDataStat.source')" for="info-item-visit-data-stat-source">Source</label>
                        <select class="form-control" name="source" :class="{'valid': !$v.infoItemVisitDataStat.source.$invalid, 'invalid': $v.infoItemVisitDataStat.source.$invalid }" v-model="$v.infoItemVisitDataStat.source.$model" id="info-item-visit-data-stat-source" >
                            <option value="SEARCH" v-bind:label="$t('vip1App.VisitSource.SEARCH')">SEARCH</option>
                            <option value="LIST" v-bind:label="$t('vip1App.VisitSource.LIST')">LIST</option>
                            <option value="PUSH" v-bind:label="$t('vip1App.VisitSource.PUSH')">PUSH</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.infoItemVisitDataStat.termimal')" for="info-item-visit-data-stat-termimal">Termimal</label>
                        <input type="text" class="form-control" name="termimal" id="info-item-visit-data-stat-termimal"
                            :class="{'valid': !$v.infoItemVisitDataStat.termimal.$invalid, 'invalid': $v.infoItemVisitDataStat.termimal.$invalid }" v-model="$v.infoItemVisitDataStat.termimal.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.infoItemVisitDataStat.replyCount')" for="info-item-visit-data-stat-replyCount">Reply Count</label>
                        <input type="number" class="form-control" name="replyCount" id="info-item-visit-data-stat-replyCount"
                            :class="{'valid': !$v.infoItemVisitDataStat.replyCount.$invalid, 'invalid': $v.infoItemVisitDataStat.replyCount.$invalid }" v-model.number="$v.infoItemVisitDataStat.replyCount.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.infoItemVisitDataStat.starCount')" for="info-item-visit-data-stat-starCount">Star Count</label>
                        <input type="number" class="form-control" name="starCount" id="info-item-visit-data-stat-starCount"
                            :class="{'valid': !$v.infoItemVisitDataStat.starCount.$invalid, 'invalid': $v.infoItemVisitDataStat.starCount.$invalid }" v-model.number="$v.infoItemVisitDataStat.starCount.$model" />
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.infoItemVisitDataStat.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./info-item-visit-data-stat-update.component.ts">
</script>
