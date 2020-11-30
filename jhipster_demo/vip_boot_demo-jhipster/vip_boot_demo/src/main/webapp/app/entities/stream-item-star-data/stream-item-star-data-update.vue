<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="vip1App.streamItemStarData.home.createOrEditLabel" v-text="$t('vip1App.streamItemStarData.home.createOrEditLabel')">Create or edit a StreamItemStarData</h2>
                <div>
                    <div class="form-group" v-if="streamItemStarData.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="streamItemStarData.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.streamItemStarData.userId')" for="stream-item-star-data-userId">User Id</label>
                        <input type="number" class="form-control" name="userId" id="stream-item-star-data-userId"
                            :class="{'valid': !$v.streamItemStarData.userId.$invalid, 'invalid': $v.streamItemStarData.userId.$invalid }" v-model.number="$v.streamItemStarData.userId.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.streamItemStarData.createDate')" for="stream-item-star-data-createDate">Create Date</label>
                        <div class="d-flex">
                            <input id="stream-item-star-data-createDate" type="datetime-local" class="form-control" name="createDate" :class="{'valid': !$v.streamItemStarData.createDate.$invalid, 'invalid': $v.streamItemStarData.createDate.$invalid }"
                            
                            :value="convertDateTimeFromServer($v.streamItemStarData.createDate.$model)"
                            @change="updateZonedDateTimeField('createDate', $event)"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.streamItemStarData.type')" for="stream-item-star-data-type">Type</label>
                        <input type="number" class="form-control" name="type" id="stream-item-star-data-type"
                            :class="{'valid': !$v.streamItemStarData.type.$invalid, 'invalid': $v.streamItemStarData.type.$invalid }" v-model.number="$v.streamItemStarData.type.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.streamItemStarData.itemId')" for="stream-item-star-data-itemId">Item Id</label>
                        <input type="text" class="form-control" name="itemId" id="stream-item-star-data-itemId"
                            :class="{'valid': !$v.streamItemStarData.itemId.$invalid, 'invalid': $v.streamItemStarData.itemId.$invalid }" v-model="$v.streamItemStarData.itemId.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.streamItemStarData.replayId')" for="stream-item-star-data-replayId">Replay Id</label>
                        <input type="text" class="form-control" name="replayId" id="stream-item-star-data-replayId"
                            :class="{'valid': !$v.streamItemStarData.replayId.$invalid, 'invalid': $v.streamItemStarData.replayId.$invalid }" v-model="$v.streamItemStarData.replayId.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.streamItemStarData.valid')" for="stream-item-star-data-valid">Valid</label>
                        <input type="checkbox" class="form-check" name="valid" id="stream-item-star-data-valid"
                            :class="{'valid': !$v.streamItemStarData.valid.$invalid, 'invalid': $v.streamItemStarData.valid.$invalid }" v-model="$v.streamItemStarData.valid.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.streamItemStarData.starType')" for="stream-item-star-data-starType">Star Type</label>
                        <input type="number" class="form-control" name="starType" id="stream-item-star-data-starType"
                            :class="{'valid': !$v.streamItemStarData.starType.$invalid, 'invalid': $v.streamItemStarData.starType.$invalid }" v-model.number="$v.streamItemStarData.starType.$model" />
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.streamItemStarData.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./stream-item-star-data-update.component.ts">
</script>
