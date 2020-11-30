<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="vip1App.infoItemVisitData.home.createOrEditLabel" v-text="$t('vip1App.infoItemVisitData.home.createOrEditLabel')">Create or edit a InfoItemVisitData</h2>
                <div>
                    <div class="form-group" v-if="infoItemVisitData.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="infoItemVisitData.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.infoItemVisitData.userId')" for="info-item-visit-data-userId">User Id</label>
                        <input type="text" class="form-control" name="userId" id="info-item-visit-data-userId"
                            :class="{'valid': !$v.infoItemVisitData.userId.$invalid, 'invalid': $v.infoItemVisitData.userId.$invalid }" v-model="$v.infoItemVisitData.userId.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.infoItemVisitData.deviceNo')" for="info-item-visit-data-deviceNo">Device No</label>
                        <input type="text" class="form-control" name="deviceNo" id="info-item-visit-data-deviceNo"
                            :class="{'valid': !$v.infoItemVisitData.deviceNo.$invalid, 'invalid': $v.infoItemVisitData.deviceNo.$invalid }" v-model="$v.infoItemVisitData.deviceNo.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.infoItemVisitData.date')" for="info-item-visit-data-date">Date</label>
                        <div class="input-group">
                            <input id="info-item-visit-data-date" type="date" class="form-control" name="date"  :class="{'valid': !$v.infoItemVisitData.date.$invalid, 'invalid': $v.infoItemVisitData.date.$invalid }"
                            v-model="$v.infoItemVisitData.date.$model"  />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.infoItemVisitData.source')" for="info-item-visit-data-source">Source</label>
                        <select class="form-control" name="source" :class="{'valid': !$v.infoItemVisitData.source.$invalid, 'invalid': $v.infoItemVisitData.source.$invalid }" v-model="$v.infoItemVisitData.source.$model" id="info-item-visit-data-source" >
                            <option value="SEARCH" v-bind:label="$t('vip1App.VisitSource.SEARCH')">SEARCH</option>
                            <option value="LIST" v-bind:label="$t('vip1App.VisitSource.LIST')">LIST</option>
                            <option value="PUSH" v-bind:label="$t('vip1App.VisitSource.PUSH')">PUSH</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.infoItemVisitData.action')" for="info-item-visit-data-action">Action</label>
                        <input type="text" class="form-control" name="action" id="info-item-visit-data-action"
                            :class="{'valid': !$v.infoItemVisitData.action.$invalid, 'invalid': $v.infoItemVisitData.action.$invalid }" v-model="$v.infoItemVisitData.action.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.infoItemVisitData.goods')" for="info-item-visit-data-goods">Goods</label>
                        <input type="number" class="form-control" name="goods" id="info-item-visit-data-goods"
                            :class="{'valid': !$v.infoItemVisitData.goods.$invalid, 'invalid': $v.infoItemVisitData.goods.$invalid }" v-model.number="$v.infoItemVisitData.goods.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.infoItemVisitData.termimal')" for="info-item-visit-data-termimal">Termimal</label>
                        <input type="text" class="form-control" name="termimal" id="info-item-visit-data-termimal"
                            :class="{'valid': !$v.infoItemVisitData.termimal.$invalid, 'invalid': $v.infoItemVisitData.termimal.$invalid }" v-model="$v.infoItemVisitData.termimal.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.infoItemVisitData.streamItem')" for="info-item-visit-data-streamItem">Stream Item</label>
                        <select class="form-control" id="info-item-visit-data-streamItem" name="streamItem" v-model="infoItemVisitData.streamItemId">
                            <option v-bind:value="null"></option>
                            <option v-bind:value="infoStreamItemOption.id" v-for="infoStreamItemOption in infoStreamItems" :key="infoStreamItemOption.id">{{infoStreamItemOption.id}}</option>
                        </select>
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.infoItemVisitData.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./info-item-visit-data-update.component.ts">
</script>
